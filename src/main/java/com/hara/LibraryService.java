package com.hara;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class LibraryService {
    private MongoCollection<Document> collection;

    public LibraryService() {
        MongoDatabase database = MongoDBConnection.getDatabase();
        this.collection = database.getCollection("books");
    }

    // Create
    public void addBook(String title, String author) {
        Document book = new Document("title", title)
                .append("author", author);
        collection.insertOne(book);
    }

    // Read
    public void listBooks() {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    // Update
    public void updateBook(String oldTitle, String newTitle, String newAuthor) {
        Document updatedBook = new Document("title", newTitle)
                .append("author", newAuthor);
        collection.updateOne(eq("title", oldTitle), new Document("$set", updatedBook));
    }

    // Delete
    public void deleteBook(String title) {
        collection.deleteOne(eq("title", title));
    }
}
