package za.co.bbd.myApp.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import za.co.bbd.myApp.model.SampleEntity;

/**
 * Backing bean for SampleEntity entities.
 * <p/>
 * This class provides CRUD functionality for all SampleEntity entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SampleEntityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving SampleEntity entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private SampleEntity sampleEntity;

	public SampleEntity getSampleEntity() {
		return this.sampleEntity;
	}

	public void setSampleEntity(SampleEntity sampleEntity) {
		this.sampleEntity = sampleEntity;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "example-persistence-unit", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public String create() {

		this.conversation.begin();
		this.conversation.setTimeout(1800000L);
		return "create?faces-redirect=true";
	}

	public void retrieve() {

		if (FacesContext.getCurrentInstance().isPostback()) {
			return;
		}

		if (this.conversation.isTransient()) {
			this.conversation.begin();
			this.conversation.setTimeout(1800000L);
		}

		if (this.id == null) {
			this.sampleEntity = this.example;
		} else {
			this.sampleEntity = findById(getId());
		}
	}

	public SampleEntity findById(Long id) {

		return this.entityManager.find(SampleEntity.class, id);
	}

	/*
	 * Support updating and deleting SampleEntity entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.sampleEntity);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.sampleEntity);
				return "view?faces-redirect=true&id="
						+ this.sampleEntity.getId();
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	public String delete() {
		this.conversation.end();

		try {
			SampleEntity deletableEntity = findById(getId());

			this.entityManager.remove(deletableEntity);
			this.entityManager.flush();
			return "search?faces-redirect=true";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	/*
	 * Support searching SampleEntity entities with pagination
	 */

	private int page;
	private long count;
	private List<SampleEntity> pageItems;

	private SampleEntity example = new SampleEntity();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public SampleEntity getExample() {
		return this.example;
	}

	public void setExample(SampleEntity example) {
		this.example = example;
	}

	public String search() {
		this.page = 0;
		return null;
	}

	public void paginate() {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		// Populate this.count

		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		Root<SampleEntity> root = countCriteria.from(SampleEntity.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<SampleEntity> criteria = builder
				.createQuery(SampleEntity.class);
		root = criteria.from(SampleEntity.class);
		TypedQuery<SampleEntity> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<SampleEntity> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String sampleField = this.example.getSampleField();
		if (sampleField != null && !"".equals(sampleField)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("sampleField")),
					'%' + sampleField.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<SampleEntity> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back SampleEntity entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<SampleEntity> getAll() {

		CriteriaQuery<SampleEntity> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(SampleEntity.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(SampleEntity.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SampleEntityBean ejbProxy = this.sessionContext
				.getBusinessObject(SampleEntityBean.class);

		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context,
					UIComponent component, String value) {

				return ejbProxy.findById(Long.valueOf(value));
			}

			@Override
			public String getAsString(FacesContext context,
					UIComponent component, Object value) {

				if (value == null) {
					return "";
				}

				return String.valueOf(((SampleEntity) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private SampleEntity add = new SampleEntity();

	public SampleEntity getAdd() {
		return this.add;
	}

	public SampleEntity getAdded() {
		SampleEntity added = this.add;
		this.add = new SampleEntity();
		return added;
	}
}
