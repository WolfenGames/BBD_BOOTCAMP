using System;

namespace delegates_and_events
{
    class Program
    {
        public delegate void Calculate(int x, int y);
        public static void Add(int x, int y) { Console.WriteLine( x + y ); }
        public static void Multiply(int x, int y) { Console.WriteLine( x * y ); }

        // Standard Stuff;
        static void Main(string[] args)
        {
            var     p = new PublishEvent();

            p.HandleEvent += (sender, e) => { Console.WriteLine("Subscribed {0}::{1}", sender, e); };
            p.HandleEvent += HandleMyEvent;

            Calculate add = Add;
            Calculate multiply = Multiply;
            Calculate allCalc = add + multiply;

            add(2, 3);
            DoCalc(add);

            // Chains the methods together.
            allCalc(5, 6);

            p.Run();
            
            Console.WriteLine("After Unsubscribed");
            p.HandleEvent -= HandleMyEvent;

            p.Run();
        }

        // Extra stuff
        private static void HandleMyEvent(Object sender, EventArgs e) {
            Console.WriteLine("Yay!");
        }
        private static void DoCalc(Calculate someMethod) {
            someMethod(5, 5);
        }
    }
}
