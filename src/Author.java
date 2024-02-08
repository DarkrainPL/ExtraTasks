import java.util.ArrayList;
import java.util.Objects;

public class Author {
    private String name;
    private int age;
    private String favouriteGenre;


    public Author(String name, int age, String favouriteGenre) {
        this.name = name;
        this.age = age;
        this.favouriteGenre = favouriteGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavouriteGenre() {
        return favouriteGenre;
    }

    public void setFavouriteGenre(String favouriteGenre) {
        this.favouriteGenre = favouriteGenre;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favouriteGenre='" + favouriteGenre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return getAge() == author.getAge() && Objects.equals(getName(), author.getName()) && Objects.equals(getFavouriteGenre(), author.getFavouriteGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getFavouriteGenre());
    }
}
