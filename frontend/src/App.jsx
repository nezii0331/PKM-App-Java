import { useEffect, useState } from "react";
import { fetchNotes, createNote } from "./api/notes";

export default function App() {
  // state: list, loading, error, form fields
  const [notes, setNotes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [err, setErr] = useState("");
  const [form, setForm] = useState({
    title: "",
    content: "",
    status: "learning",
    tags: "",
  });

  // when first enter the page, fetch data
  useEffect(() => {
    (async () => {
      try {
        const data = await fetchNotes();
        setNotes(data);
      } catch (e) {
        setErr(String(e));
      } finally {
        setLoading(false);
      }
    })();
  }, []);

  // form submit: call POST -> add to the list -> clear form
  async function onSubmit(e) {
    e.preventDefault();
    setErr("");

    const payload = {
      title: form.title.trim(),
      content: form.content.trim(),
      status: form.status,
      // backend is List<String>, here use comma to separate and turn into array
      tags: form.tags
        .split(",")
        .map(s => s.trim())
        .filter(Boolean),
    };

    if (!payload.title) {
      setErr("title cannot be empty");
      return;
    }

    try {
      const created = await createNote(payload);
      // add to the top of the list
      setNotes(prev => [created, ...prev]);
      // clear form
      setForm({ title: "", content: "", status: "learning", tags: "" });
    } catch (e) {
      setErr(String(e));
    }
  }

  return (
    <main style={{ maxWidth: 720, margin: "40px auto", fontFamily: "system-ui" }}>
      <h1>📘 PKM Notes</h1>

      {/* simple create form */}
      <form onSubmit={onSubmit} style={{ marginBottom: 24, display: "grid", gap: 8 }}>
        <input
          placeholder="Title"
          value={form.title}
          onChange={e => setForm({ ...form, title: e.target.value })}
        />
        <textarea
          placeholder="Content"
          rows={3}
          value={form.content}
          onChange={e => setForm({ ...form, content: e.target.value })}
        />
        <select
          value={form.status}
          onChange={e => setForm({ ...form, status: e.target.value })}
        >
          <option value="learning">learning</option>
          <option value="doing">doing</option>
          <option value="done">done</option>
        </select>
        <input
          placeholder="tags（use comma to separate, like: java,spring）"
          value={form.tags}
          onChange={e => setForm({ ...form, tags: e.target.value })}
        />
        <button type="submit">＋ CREATE NOTE</button>
      </form>

      {err && <p style={{ color: "red" }}>{err}</p>}
      {loading ? (
        <p>Loading…</p>
      ) : notes.length === 0 ? (
        <p>No notes yet.</p>
      ) : (
        <ul>
          {notes.map(n => (
            <li key={n.id} style={{ marginBottom: 12 }}>
              <strong>{n.title || "(no title)"}</strong> — {n.status || "-"}
              {n.tags?.length ? (
                <div style={{ opacity: 0.7 }}>tags: {n.tags.join(", ")}</div>
              ) : null}
              <div style={{ fontSize: 12, opacity: 0.6 }}>
                created: {n.createdAt?.slice(0, 19)?.replace("T", " ")}
              </div>
            </li>
          ))}
        </ul>
      )}
    </main>
  );
}
