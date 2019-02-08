using System;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace Advanced
{
    class Program
    {
        [Serializable]
        public class  MyObject {
            public int n1 = 0, n2 = 0;
            public string str = "Wee"; 
        }
        static void Main(string[] args)
        {
            MyObject obj = new MyObject();
            IFormatter formatter = new BinaryFormatter();
            Stream stream = new FileStream("MyFile.bin", FileMode.Create, FileAccess.Write, FileShare.None);
            formatter.Serialize(stream, obj);
            stream.Close();

        }
    }
}
