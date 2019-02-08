using System;

namespace arrays_and_stuff
{
    class Program
    {
        static void Main(string[] args)
        {
            // Arrays and shit
            int[] a = new int[9];
            int[] b = a;
            int[] c = new int[] {1, 3, 5, 7};
            
            // Multi
            int[,] d = new int[,] {{1, 2}, {2, 3}};

            // Jagged
            int[][] e = new int[3][];

            e[0] = new int[1]; // Size 1
            e[1] = new int[2]; // Size 2
            e[2] = new int[3]; // Size 3

            Console.WriteLine("I did a thing, You can't see it though");

            string aS = "I am a sentence";
            var ab = aS.Split(' ');
            // Array of String;
            var ac = String.Join("\t\t", ab);
            Console.WriteLine(ac);
            ac = ChangeString(ac);
            Console.WriteLine(ac);
        }

        private static string ChangeString(string mystring) {
            return "Something else";
        }
    }
}
