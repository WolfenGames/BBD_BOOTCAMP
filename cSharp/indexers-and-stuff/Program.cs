using System;

namespace indexers_and_stuff
{
    class SampleCollection<T>
    {
        private T[] arr = new T[100];
        int nextIndex = 0;

        public T this[int i] => arr[i];

        public void Add(T value)
        {
            if (nextIndex >= arr.Length)
                throw new IndexOutOfRangeException($"The collection can hold only {arr.Length} elements.");
            arr[nextIndex++] = value;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var stringCollection = new SampleCollection<string>();
            stringCollection.Add("Hello, World");
            Console.WriteLine(stringCollection[0]);
        }
    }
}
