package id.rakhmad.demo.rest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private Set<Book> books = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public BookResource() {
        books.add(new Book("Effective Java", "Joshua Bloch", "978-0134685991", "‎Addison-Wesley Professional"));
        books.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin",
                " 978-0132350884", "Pearson"));
        books.add(new Book("The Pragmatic Programmer: Your Journey To Mastery", "David Thomas", " 978-0135957059",
                "‎Addison-Wesley Professional"));
        books.add(new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, et. al.",
                " 978-0201633610", "‎Addison-Wesley Professional"));
        books.add(new Book("Refactoring: Improving the Design of Existing Code (2nd Edition) ", "Martin Fowler",
                " 978-0134757599", "‎Addison-Wesley Professional"));
        books.add(new Book("Working Effectively with Legacy Code", "Michael Fethers", " 978-0131177055", "‎Pearson"));
        books.add(new Book("Test Driven Development: By Example", "Kent Beck", " 978-0321146533",
                "‎ Addison-Wesley Professional"));
        books.add(new Book("Extreme Programming Explained: Embrace Change, 2nd Edition", "Kent Beck", "978-0321278654",
                "‎Addison-Wesley Professional"));
        books.add(new Book("Patterns of Enterprise Application Architecture", "Martin Fowler", "978-0321127426",
                "‎Addison-Wesley Professional"));
        books.add(new Book("Domain-Driven Design: Tackling Complexity in the Heart of Software", "Eric Evans",
                "978-0321125217", "‎Addison-Wesley Professional"));
    }

    @GET
    public Response list() {
        return Response.ok(books).build();
    }

    @POST
    public Response add(Book book) {
        books.add(book);
        return Response.status(Status.ACCEPTED).entity(books).build();
    }

    @DELETE
    public Response delete(Book book) {
        books.removeIf(existingBook -> existingBook.title.contentEquals(book.title));
        return Response.ok(books).build();
    }
}