package Lab2Equals;

public class Person {
        private String Name;
        public String getName() {
            return Name;
        }
        public void setName(String name) {
            if(name.length() > 0) Name = name;
        }

        private Integer Age;
        public Integer getAge(){
            return Age;
        }
        public  void setAge(Integer age){
            if(age > 0) Age = age;
        }

        public Person(){
            Name = "unknown";
            Age = 0;
        }
        public Person(String name, Integer age){
            this.Age = age;
            this.Name = name;
        }

        @Override
        public final boolean equals(Object obj){
            if(!(obj instanceof Person) || obj == null)
            {
                return false;
            }
            Person person = (Person)obj;

            if(this.Name == null && person.getName() == null)
            {
                if(this.Age == null && person.getAge() == null)
                {
                    return true;
                }
                else if(this.Age == null ^ person.getAge() == null) return false;
                else return this.Age.equals(person.getAge());
            }
            else if(this.Name != null && person.getName() != null)
            {
                if (this.Name.equals(person.getName()))
                {
                    if (this.Age == null && person.getAge() == null)
                    {
                        return true;
                    }
                    else if(this.Age == null ^ person.getAge() == null) return false;
                    else return this.Age.equals(person.getAge());
                }
            }
            return false;
        }

        @Override
        public final int hashCode(){
            return (this.Age == null ? 0 : this.Age) + (this.Name == null ? 0 : this.Name.hashCode());
        }

        @Override
        public String toString(){
            return "Name: " + this.Name + ", age: " + this.Age;
        }
    }

