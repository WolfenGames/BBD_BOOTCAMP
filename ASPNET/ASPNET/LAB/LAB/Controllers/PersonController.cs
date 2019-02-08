using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using LAB.Models;
using LAB.StaticData;
using Microsoft.AspNetCore.Mvc;

namespace LAB.Controllers
{
    public class PersonController : Controller
    {
        public IActionResult ListAll()
        {
            var people = PersonData.People;
            foreach(var p in people)
            {
                p.Department = DepartmenData.GetDepById(p.DepId);
            }

            return View(people);
        }

        public IActionResult Edit(int? id)
        {
            if (!id.HasValue)
            {
                return NotFound();
            }

            var person = PersonData.People.FirstOrDefault(p => p.Id == id.Value);

            if (person == null)
            {
                return NotFound();
            }
            person.Department = DepartmenData.GetDepById(person.DepId);
            person.Dep = DepartmenData.DepartmentsList;

            return View(person);
        }

        public IActionResult Add()
        {
            var person = new Person
            {
                Dep = DepartmenData.DepartmentsList
            };
            return View(person);
        }

        [HttpPost]
        public IActionResult Add([Bind("Name,Department,Years")] Person person)
        {
            if (ModelState.IsValid)
            {
                person.Dep = null;
                PersonData.NewPerson(person);
                return RedirectToAction("ListAll");
            }

            person.Dep = DepartmenData.DepartmentsList;
            return View(person);
        }

        [HttpPost]
        public IActionResult Edit(int id, [Bind("Id,Name,Department,Years")] Person person)
        {
            if (id != person.Id)
            {
                return NotFound();
            }
            if (ModelState.IsValid)
            {
                person.Dep = null;
                PersonData.UpdatePerson(id, person);
                return RedirectToAction("ListAll");
            }
            person.Dep = DepartmenData.DepartmentsList;
            return View(person);
        }

        public IActionResult Delete(int ?id)
        {
            if (!id.HasValue)
            {
                return NotFound();
            }

            var person = PersonData.People.FirstOrDefault(p => p.Id == id.Value);

            if (person == null)
            {
                return NotFound();
            }
            return View(person);
        }

        [HttpPost]
        public IActionResult Delete(int? id, [Bind("Id")] Person pers)
        {
            var person = PersonData.People.FirstOrDefault(p => p.Id == id.Value);

            if (person != null)
            {
                PersonData.People.Remove(person);
            }
            return RedirectToAction("ListAll");
        }
    }
}