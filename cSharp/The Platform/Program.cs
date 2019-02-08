using System;


namespace The_Platform
{
    /*
        Associate information with code, Metadata...etc;
        Add it where you like O.O;
        Extra Informations
        Validations; OOOOOOOH
        Usefull:: -> Not created till queried, Saves space, WHOOHOO
     */
    // [System.AttributeUsage(System.Atrribute.All, AllowMultiple = true)] <- vars and class, methods and shit
    // inherited, by derived from base class
    [System.AttributeUsage(System.AttributeTargets.Class, AllowMultiple = true)]
    public class MyAttribute : System.Attribute
    {
        private string privateProperty;
        public string PublicProperty;

        public MyAttribute(string privateProperty)
        {
            this.privateProperty = privateProperty;
            PublicProperty = "This is the default value";
        }
    }

    [Serializable()]
    public class MyCustomException : System.Exception
    {
        public MyCustomException() : base() { }
        public MyCustomException(string message) : base(message) { }
        public MyCustomException(string message, System.Exception inner)
            : base(message, inner) { }

        protected MyCustomException(
            System.Runtime.Serialization.SerializationInfo info,
            System.Runtime.Serialization.StreamingContext context)
        { }
    }

    [My("Something", PublicProperty = "WEEEE00")]
    class MyClass { };

    // class SomeClass
    // {
    //     [return: SomeAtribute]
    //     int someMethod() {
    //         return 0;
    //     }
    // }

    // MyClass mc = new MyClass();
    // var t = typeof(MyClass);
    // object[] a = t.GetCustomAttributes(true);
    // Console.WriteLine(a.Length);
    // foreach (var b in a)
    // {
    //     Console.WriteLine(b);
    // }

    // try {
    // }
    // // Order is key
    // catch (Exception ex) {
    // }
    // finally { <- good to close connections and files;
    // }

    class Program
    {
        static void Main(string[] args)
        {
        }
    }
}
