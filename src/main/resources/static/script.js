const form = document.getElementById("bookForm");
const table = document.getElementById("bookTable");

loadBooks();

form.addEventListener("submit", async (e) => {

    e.preventDefault();

    const book = {
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        price: document.getElementById("price").value,
        category: document.getElementById("category").value,
        imageUrl: document.getElementById("imageUrl").value
    };

    await fetch("/books", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(book)
    });

    form.reset();

    loadBooks();
});

async function loadBooks() {

    const response = await fetch("/books");
    const books = await response.json();

    displayBooks(books);
}

function displayBooks(books) {

    table.innerHTML = "";

    books.forEach(book => {

        table.innerHTML += `
            <tr>
                <td>${book.id}</td>

                <td>
                    <img src="${book.imageUrl}"
                         width="80"
                         height="100"
                         alt="Book">
                </td>

                <td>${book.title}</td>

                <td>${book.author}</td>

                <td>₹${book.price}</td>

                <td>${book.category}</td>

                <td>
                    <button onclick="deleteBook(${book.id})">
                        Delete
                    </button>
                </td>
            </tr>
        `;
    });
}

async function deleteBook(id) {

    if (!confirm("Delete this book?")) {
        return;
    }

    await fetch(`/books/${id}`, {
        method: "DELETE"
    });

    loadBooks();
}

async function searchBooks() {

    const keyword =
        document.getElementById("searchBox").value;

    if (keyword.trim() === "") {
        loadBooks();
        return;
    }

    const response =
        await fetch(`/books/search/title/${keyword}`);

    const books = await response.json();

    displayBooks(books);
}