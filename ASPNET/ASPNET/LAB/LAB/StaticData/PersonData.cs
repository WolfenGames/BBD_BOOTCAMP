using LAB.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LAB.StaticData
{
    public class PersonData
    {
        public static List<Person> People
        {
            get
            {
                return listOfPeople;
            }
        }

        private static List<Person> listOfPeople = new List<Person>()
        {
            new Person() { Id = 1, Name = "Gery", DepId = 1, Years = 4.9M },
            new Person() { Id = 2, Name = "Rory", DepId = 1, Years = 15.2M },
            new Person() { Id = 3, Name = "Mike", DepId = 1, Years = 5.5M },
            new Person() { Id = 4, Name = "R2-D2", DepId = 3, Years = 123.45M },
            new Person() { Id = 5, Name = "BB-8", DepId = 3, Years = 555.55M },
            new Person() { Id = 6, Name = "C1-10P", DepId = 4, Years = 99 },
            new Person() { Id = 7, Name = "BB-8 v2", DepId = 6, Years = 555.55M },
            new Person() { Id = 8, Name = "C1-10P v2", DepId = 6, Years = 99 },
        };

        public static void UpdatePerson(int idToUpdate, Person newPerson)
        {
            var existingPerson = listOfPeople.FirstOrDefault(p => p.Id == idToUpdate);
            if (existingPerson != null)
            {
                existingPerson.Name = newPerson.Name;
                existingPerson.DepId = DepartmenData.GetDepByName(newPerson.Department);
                existingPerson.Years = newPerson.Years;
                existingPerson.Dep = null;
            }
        }

        public static void NewPerson(Person person)
        {
            var x = listOfPeople.ToArray();
            if (x.Length > 0)
                person.Id = x[x.Length - 1].Id + 1;
            else
                person.Id = 1;
            person.DepId = DepartmenData.GetDepByName(person.Department);
            listOfPeople.Add(person);
        }
    }
}
