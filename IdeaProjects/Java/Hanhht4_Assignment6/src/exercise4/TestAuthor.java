package exercise4;

public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Hanh", "hanh@gmail.com", 'm');
        System.out.println(author.getName());
        System.out.println(author.getEmail());
        author.setEmail("hanh123@gmail.com");
        System.out.println(author.getGender());
        System.out.println(author.toString());

    }
}
