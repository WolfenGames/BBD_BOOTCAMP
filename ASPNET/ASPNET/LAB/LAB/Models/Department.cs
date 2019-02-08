using System.ComponentModel.DataAnnotations;

namespace LAB.Models
{
    public class Departments
    {
        [Required]
        public int Id { get; set; }
        [Required]
        public string Name { get; set; }
    }
}