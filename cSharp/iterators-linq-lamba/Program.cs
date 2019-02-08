using System;
using System.Collections.Generic;
using System.Linq;

namespace iterators_linq_lamba
{
    class Program
    {
        static int Main(string[] args)
        {
            int intOne = 123;
            object objOne = (object)intOne;
            int intTwo = (int)objOne;
            intOne = 456;
            Console.WriteLine($"{intOne}, {intTwo}");
            // Linq Method, using System.Linq;
            var lambdaNumbers = new List<int> { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            var numbers = lambdaNumbers.Select(x => x * x);

            foreach (var num in numbers)
            {
                Console.WriteLine(num);
            }

            foreach (var num in SquareNumbers(0, 10))
            {
                Console.WriteLine(num);
            }

            // LINQ NOT EXECUTED UNTIL ENUMERATED
            var numbersQuery =
                from number in SquareNumbers(0, 10)
                where number < 40
                select number;
            foreach (var number in numbersQuery)
            {
                Console.WriteLine(number);
            }

            Del myDel = WriteString;
            myDel("Weee");

            Del LambaDel = (string str) =>
            {
                Console.WriteLine(str);
            };
            LambaDel("This is a string");

            //Linq Methods, Have fun
            var q = new List<int>() { 1, 2, 4, 5, 6, 7, 8, 9, 0 };

            var a = "123";
            var b = a is System.Int32;
            Console.WriteLine(b);

            return 0;

            Console.WriteLine("1");

        }

        // Using System.Collections.Generic
        private static IEnumerable<int> SquareNumbers(int start, int finish)
        {
            for (var i = start; i < finish; i++)
            {
                yield return i * i;
            }
        }

        delegate void Del(string str);
        public static void WriteString(string str)
        {
            Console.WriteLine(str);
        }

        // Anonymous

        Del myAnonymousDel = delegate (string str)
        {
            Console.WriteLine(str);
        };

        //LambdaDel
        Del LambaDel = (string str) =>
        {
            Console.WriteLine(str);
        };
    }
}
