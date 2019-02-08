using System;

namespace _8Ball
{
    class Program
    {
        static void Main(string[] args)
        {
           string[] responses = new string[]{
               "Yes",
               "No",
               "I don't see it in your foreseable future",
               "I don't know what I am doing?",
               "This is something I dont see happening",
               "BBD IS THE BEST"
           };
           Random rnd = new Random();

           if (args.Length == 1) {
               int  x = rnd.Next(responses.Length);
                Console.WriteLine($"The answer to your question: {args[0]} is : {responses[x]}");
           }
           else
           {
               Console.WriteLine("Lord Geff would be unimpressed with you");
           }
        }
    }
}
