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
    public class Department : Controller
    {
        public IActionResult ListAll()
        {
            var department = DepartmenData.DepartmentsList;

            return View(department);
        }

        public IActionResult Edit(int? id)
        {
            if (!id.HasValue)
            {
                return NotFound();
            }

            var department = DepartmenData.DepartmentsList.FirstOrDefault(p => p.Id == id.Value);

            if (department == null)
            {
                return NotFound();
            }

            return View(department);
        }

        [HttpPost]
        public IActionResult Edit(int id, [Bind("Id, Name")] Departments department)
        {
            if (id != department.Id)
            {
                return NotFound();
            }
            if (ModelState.IsValid)
            {
                DepartmenData.UpdateDepartment(id, department);
                return RedirectToAction("ListAll");
            }
            return View(department);
        }

        public IActionResult Add()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Add([Bind("Name")] Departments department)
        {
            if (ModelState.IsValid)
            {
                DepartmenData.AddDep(department);
                return RedirectToAction("ListAll");
            }

            return View();
        }


        public IActionResult Delete(int ?id)
        {
            if (!id.HasValue)
            {
                return NotFound();
            }

            var dep = DepartmenData.DepartmentsList.FirstOrDefault(p => p.Id == id.Value);

            if (dep == null)
            {
                return NotFound();
            }
            return View(dep);
        }

        [HttpPost]
        public IActionResult Delete(int? id, [Bind("Id")] Person pers)
        {
            var dep = DepartmenData.DepartmentsList.FirstOrDefault(p => p.Id == id.Value);

            if (dep != null)
            {
                DepartmenData.DepartmentsList.Remove(dep);
            }
            return RedirectToAction("ListAll");
        }
    }
}