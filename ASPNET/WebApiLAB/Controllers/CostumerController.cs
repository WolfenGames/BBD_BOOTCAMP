using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using CustomerInformation.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebApiLAB.Controllers
{
    [Route("api/[controller]")]
    public class CustomerController : Controller
    {
        private readonly CustomerContext _context;

        public CustomerController(CustomerContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<CustomerItem> GetAll()
        {
            return _context.CustomerItems.ToList();
        }

        [HttpGet("{id}", Name = "GetCustomers")]
        public IActionResult GetById(long id)
        {
            var item = _context.CustomerItems.FirstOrDefault(t => t.Id == id);
            if (item == null)
            {
                return NotFound();
            }
            return new ObjectResult(item);
        }

        [HttpPost]
        public IActionResult Create([FromBody] CustomerItem item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.CustomerItems.Add(item);
            _context.SaveChanges();

            return CreatedAtRoute("GetCustomers", new { id = item.Id }, item);
        }

        [HttpPut("{id}")]
        public IActionResult Update(long id, [FromBody] CustomerItem item)
        {
            if (item == null || item.Id != id)
            {
                return BadRequest();
            }

            var customer = _context.CustomerItems.FirstOrDefault(t => t.Id == id);
            if (customer == null)
            {
                return NotFound();
            }

            customer.FirstName = item.FirstName;
            customer.LastName = item.LastName;
            customer.Email = item.Email;
            customer.Phone = item.Phone;
            customer.Address = item.Address;
            customer.City = item.City;
            customer.State = item.State;
            customer.PostalAdress = item.PostalAdress;

            _context.CustomerItems.Update(customer);
            _context.SaveChanges();
            return new NoContentResult();
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(long id)
        {
            var customer = _context.CustomerItems.FirstOrDefault(t => t.Id == id); if (todo == null)
            {
                return NotFound();
            }

            _context.CustomerItems.Remove(customer);
            _context.SaveChanges();
            return new NoContentResult();
        }
    }
}
