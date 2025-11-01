const BASE = import.meta.env.VITE_API_BASE || "http://localhost:8080";
console.log("VITE_API_BASE =", import.meta.env.VITE_API_BASE);

// fetch all notes
export async function fetchNotes() {
  const res = await fetch(`${BASE}/api/notes`);
  if (!res.ok) throw new Error("Failed to fetch notes: " + res.status);
  return res.json();
}

// create one note
export async function createNote(note) {
  const res = await fetch(`${BASE}/api/notes`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(note),
  });
  if (!res.ok) throw new Error("Failed to create note: " + res.status);
  return res.json(); // backend will return the new created Note
}
