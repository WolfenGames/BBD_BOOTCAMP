using LAB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LAB.StaticData
{
    public class DepartmenData
    {
        public static List<Departments> DepartmentsList
        {
            get
            {
                return listOfDepartments;
            }
        }

        private static readonly List<Departments> listOfDepartments = new List<Departments>()
        {
            new Departments() { Id = 1, Name = "ATC" },
            new Departments() { Id = 2, Name = "HR" },
            new Departments() { Id = 3, Name = "Directors" },
            new Departments() { Id = 4, Name = "Executives" },
            new Departments() { Id = 5, Name = "Lackies" },
            new Departments() { Id = 6, Name = "We Think Coders" },
            new Departments() { Id = 7, Name = "Jedi" },
            new Departments() { Id = 8, Name = "Sith" }
        };

        public static void UpdateDepartment(int idToUpdate, Departments department)
        {
            var existing = DepartmentsList.FirstOrDefault(p => (p.Id == idToUpdate || p.Name == department.Name));
            if (existing != null)
            {
                existing.Name = department.Name;
            }
        }

        public static string GetDepById(int id)
        {
            var existing = DepartmentsList.FirstOrDefault(p => p.Id == id);
            if (existing != null)
                return (existing.Name);
            else
                return ("Department No Longer Exists");
        }

        public static int GetDepByName(string department)
        {
            var existing = DepartmentsList.FirstOrDefault(p => p.Name == department);
            if (existing != null)
                return (existing.Id);
            else
                return (1);
        }

        public static void AddDep(Departments dep)
        {
            var x = DepartmentsList.ToArray();
            if (x.Length > 0)
            {
                dep.Id = x[x.Length - 1].Id + 1;

                DepartmentsList.Add(dep);
            }
            else
            {
                var newDep = new Departments()
                {
                    Id = 1,
                    Name = "Default"
                };
                DepartmentsList.Add(newDep);
            }
        }
    }
}
