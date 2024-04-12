</head>
<body>
    <div class="container">
        <h1>Traccia:</h1>
        <p><strong>Obiettivo:</strong> Creare un'applicazione Spring per gestire una lista di libri con operazioni CRUD e logica di business per il controllo del prestito dei libri.</p>
        <h2>Requisiti:</h2>
        <ol>
            <li>Ogni libro deve avere un titolo, un autore, un anno di pubblicazione e uno stato di disponibilità (prestato o disponibile).</li>
            <li>L'applicazione deve consentire di:
                <ul>
                    <li>Aggiungere un nuovo libro.</li>
                    <li>Visualizzare l'elenco completo dei libri.</li>
                    <li>Visualizzare i dettagli di un libro specifico.</li>
                    <li>Modificare i dettagli di un libro esistente.</li>
                    <li>Rimuovere un libro dall'elenco.</li>
                    <li>Gestire lo stato di disponibilità di un libro (prestare o restituire).</li>
                </ul>
            </li>
            <li>La logica di business deve includere:
                <ul>
                    <li>Controllo sulla disponibilità del libro prima di prestare.</li>
                    <li>Controllo sul numero massimo di libri prestabili per utente.</li>
                    <li>Controllo sulla restituzione dei libri in prestito.</li>
                </ul>
            </li>
        </ol>
        <h2>Implementazione:</h2>
        <ol>
            <li><strong>Classe Book:</strong>
                <ul>
                    <li>Attributi: id, titolo, autore, anno di pubblicazione, disponibilità.</li>
                    <li>Metodi: getter e setter per tutti gli attributi.</li>
                </ul>
            </li>
            <li><strong>Classe BookService:</strong>
                <ul>
                    <li>Interfaccia contenente i metodi per la logica di business sui libri.</li>
                    <li>Metodi:
                        <ul>
                            <li><code>List&lt;Book&gt; getAllBooks()</code>: Restituisce l'elenco completo dei libri.</li>
                            <li><code>Book getBookById(int id)</code>: Restituisce un libro specifico per ID.</li>
                            <li><code>void addBook(Book book)</code>: Aggiunge un nuovo libro.</li>
                            <li><code>void updateBook(int id, Book book)</code>: Aggiorna i dettagli di un libro.</li>
                            <li><code>void deleteBook(int id)</code>: Rimuove un libro dall'elenco.</li>
                            <li><code>void lendBook(int id)</code>: Gestisce il prestito di un libro.</li>
                            <li><code>void returnBook(int id)</code>: Gestisce il ritorno di un libro prestato.</li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><strong>Classe BookController:</strong>
                <ul>
                    <li>Controller per gestire le richieste HTTP relative ai libri.</li>
                    <li>Metodi:
                        <ul>
                            <li><code>GET /books</code>: Restituisce l'elenco completo dei libri.</li>
                            <li><code>GET /books/{id}</
