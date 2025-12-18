import { useEffect, useState } from "react";
import { fetchNotes } from "./api/notes";
import Sidebar from "./components/Sidebar";
import NoteCard from "./components/NoteCard";
import NoteForm from "./components/NoteForm";
import "./App.css";

export default function App() {
  const [notes, setNotes] = useState([]);
  const [loading, setLoading] = useState(true);

  // Load notes on startup
  useEffect(() => {
    fetchNotes()
      .then(setNotes)
      .catch(console.error)
      .finally(() => setLoading(false));
  }, []);

  const addNote = (newNote) => {
    setNotes((prev) => [newNote, ...prev]);
  };

  return (
    <div className="app-layout">
      <Sidebar />

      <main className="content-area">
        <header className="title-section">
          <h1>My Knowledge Base</h1>
          <p style={{ color: 'var(--text-muted)' }}>Manage your learning journey.</p>
        </header>

        <div style={{ maxWidth: '800px', margin: '0 auto' }}>
          <NoteForm onNoteCreated={addNote} />

          <section>
            <h2 style={{ marginBottom: '1rem' }}>Recent Notes</h2>
            {loading ? (
              <p>Loading your brain...</p>
            ) : notes.length === 0 ? (
              <p style={{ opacity: 0.5 }}>No notes yet. Create one above!</p>
            ) : (
              <div className="notes-grid">
                {notes.map((note) => (
                  <NoteCard key={note.id} note={note} />
                ))}
              </div>
            )}
          </section>
        </div>
      </main>
    </div>
  );
}
