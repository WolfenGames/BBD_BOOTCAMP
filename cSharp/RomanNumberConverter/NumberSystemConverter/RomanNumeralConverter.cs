using System;
using System.Collections.Generic;

namespace NumberSystemConverter
{
    public class RomanNumeralConverter
    {
        private string GetReference(int check)
        {
            Dictionary<int, string> references = new Dictionary<int, string>(){
                { 1,        "I" },
                { 5,        "V" },
                { 10,       "X" },
                { 50,       "L" },
                { 100,      "C" },
                { 500,      "D" },
                { 1000,     "M" },
                { 4,        "IIII"},
                { 9,        "VIIII" },
                { 40,       "XXXX" },
                { 90,       "LXXXX" },
                { 400,      "CCCC" },
                { 900,      "DCCCC" }
            };
            string reply = null;
            
            references.TryGetValue(check, out reply);
            return (reply);
        }

        private string retPart(int times, bool v2, int x, int y, int z){

            string _refed = null;
            if (times == 9)
                {
                    if (v2)
                    {
                        _refed += GetReference(x);
                        _refed += GetReference(y);
                    }
                    else
                    {
                        _refed += GetReference(y - x);
                    }
                    times -= 9;
                }

                if (times >= 5)
                {
                    _refed += GetReference(z);
                    times -= 5;
                }

                if (times == 4)
                {
                    if (v2)
                    {
                        _refed += GetReference(x);
                        _refed += GetReference(z);
                    }
                    else
                    {
                        _refed += GetReference(z - x);
                    }
                    times -= 4;
                }

                for (int i = 0; i < times; i++)
                {
                    _refed += GetReference(x);
                }
                return (_refed);
        }

        public string ConvertNumber(int number, bool v2 = true)
        {
            string _refed = null;
            
            if (number > 3000 || number < 1)
            {
                throw new IndexOutOfRangeException();
            }

            #region MATH

            if (number >= 1000)
            {
                int times = (int)(number / 1000);
                number -= 1000 * times;
                if (times == 9)
                {
                    _refed += GetReference(900);
                    times -= 9;
                }
                for (int i = 0; i < times; i++)
                {
                    _refed += GetReference(1000);
                }
            }

            if (number >= 100)
            {
                int times = (int)(number / 100);
                number -= 100 * times;

                if (times == 9)
                {
                    if (v2)
                    {
                        _refed += GetReference(10);
                        _refed += GetReference(100);
                    }
                    else
                    {
                        _refed += GetReference(900);
                    }
                    times -= 9;
                }

                if (times >= 5)
                {
                    _refed += GetReference(500);
                    times -= 5;
                }

                if (times == 4)
                {
                    if (v2)
                    {
                        _refed += GetReference(100);
                        _refed += GetReference(500);
                    }
                    else
                    {
                        _refed += GetReference(400);
                    }
                    times -= 4;
                }

                for (int i = 0; i < times; i++)
                {
                    _refed += GetReference(100);
                }

            }

            if (number > 10)
            {
                int times = (int)(number / 10);
                number -= 10 * times;

                if (times == 9)
                {
                    if (v2)
                    {
                        _refed += GetReference(10);
                        _refed += GetReference(100);
                    }
                    else
                    {
                        _refed += GetReference(90);
                    }
                    times -= 9;
                }

                if (times >= 5)
                {
                    _refed += GetReference(50);
                    times -= 5;
                }

                if (times == 4)
                {
                    if (v2)
                    {
                        _refed += GetReference(10);
                        _refed += GetReference(50);
                    }
                    else
                    {
                        _refed += GetReference(40);
                    }
                    times -= 4;
                }


                for (int i = 0; i < times; i++)
                {
                    _refed += GetReference(10);
                }
            }

            if (number > 0)
            {
                int times = number;

                if (times == 9)
                {
                    if (v2)
                    {
                        _refed += GetReference(1);
                        _refed += GetReference(10);
                    }
                    else
                    {
                        _refed += GetReference(9);
                    }
                    times -= 9;
                }

                if (times >= 5)
                {
                    _refed += GetReference(5);
                    times -= 5;
                }

                if (times == 4)
                {
                    if (v2)
                    {
                        _refed += GetReference(1);
                        _refed += GetReference(5);
                    }
                    else
                    {
                        _refed += GetReference(4);
                    }
                    times -= 4;
                }

                for (int i = 0; i < times; i++)
                {
                    _refed += GetReference(1);
                }
            }
            #endregion

            if (_refed == null)
            {
                throw new NullReferenceException();
            }
            
            return (_refed);
            // throw new NotImplementedException("OI! use me you fat fuck"); 
        }
        Dictionary<char, int> GetIntRefence = new Dictionary<char, int>() {
            { 'I', 1 },
            { 'V', 5 },
            { 'X', 10 },
            { 'L', 50 },
            { 'C', 100 },
            { 'D', 500 },
            { 'M', 1000 }
        };
        public int RomanToArabic(string roman)
        {
            if (roman.Length == 0) return 0;
            roman = roman.ToUpper();

            int total = 0;
            int last_value = 0;
            for (int i = roman.Length - 1; i >= 0; i--)
            {
                int new_value = GetIntRefence[roman[i]];

                if (new_value < last_value)
                    total -= new_value;
                else
                {
                    total += new_value;
                    last_value = new_value;
                }
            }
            return total;
        }
    }
}