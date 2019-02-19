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

import za.co.bbd.myApp.model.shopping;

/**
 * Backing bean for shopping entities.
 * <p/>
 * This class provides CRUD functionality for all shopping entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class shoppingBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving shopping entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private shopping shopping;

	public shopping getshopping() {
		return this.shopping;
	}

	public void setshopping(shopping shopping) {
		this.shopping = shopping;
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
			this.shopping = this.example;
		} else {
			this.shopping = findById(getId());
		}
	}

	public shopping findById(Long id) {

		return this.entityManager.find(shopping.class, id);
	}

	/*
	 * Support updating and deleting shopping entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.shopping);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.shopping);
				return "view?faces-redirect=true&id=" + this.shopping.getId();
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
			shopping deletableEntity = findById(getId());

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
	 * Support searching shopping entities with pagination
	 */

	private int page;
	private long count;
	private List<shopping> pageItems;

	private shopping example = new shopping();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public shopping getExample() {
		return this.example;
	}

	public void setExample(shopping example) {
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
		Root<shopping> root = countCriteria.from(shopping.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<shopping> criteria = builder.createQuery(shopping.class);
		root = criteria.from(shopping.class);
		TypedQuery<shopping> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<shopping> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String item = this.example.getItem();
		if (item != null && !"".equals(item)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("item")),
					'%' + item.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<shopping> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back shopping entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<shopping> getAll() {

		CriteriaQuery<shopping> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(shopping.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(shopping.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final shoppingBean ejbProxy = this.sessionContext
				.getBusinessObject(shoppingBean.class);

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

				return String.valueOf(((shopping) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private shopping add = new shopping();

	public shopping getAdd() {
		return this.add;
	}

	public shopping getAdded() {
		shopping added = this.add;
		this.add = new shopping();
		return added;
	}
}
