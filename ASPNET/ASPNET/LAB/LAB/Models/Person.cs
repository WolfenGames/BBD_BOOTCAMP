using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Collections.Generic;

namespace LAB.Models
{
    public class Person
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required]
        public int Id { get; set; }
        [Required]
        public string Name { get; set; }
        public string Department { get; set; }
        public int DepId { get; set; }
        [Required]
        [Range(0, 650)]
        [DisplayName("Years at BBD"), DisplayFormat(DataFormatString = "{0:F1}")]
        public decimal Years { get; set; }
        public List<Departments> Dep { get; set; }

        public void SetYears(decimal dec)
        {
            this.Years = dec;
        }
    }
}