import React, { useState } from 'react';
import { createNote } from '../api/notes';

export default function NoteForm({ onNoteCreated }) {
    const [form, setForm] = useState({
        title: "",
        content: "",
        status: "learning",
        tags: "",
    });
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!form.title.trim()) {
            setError("Title is required");
            return;
        }
        setError("");
        setLoading(true);

        try {
            const payload = {
                title: form.title.trim(),
                content: form.content.trim(),
                status: form.status,
                tags: form.tags.split(",").map(s => s.trim()).filter(Boolean),
            };

            const newNote = await createNote(payload);
            onNoteCreated(newNote); // Callback to parent
            setForm({ title: "", content: "", status: "learning", tags: "" }); // Reset
        } catch (e) {
            setError("Failed to save note");
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="glass-panel" style={{ padding: '1.5rem', borderRadius: 'var(--radius-md)', marginBottom: '2rem' }}>
            <h3 style={{ marginBottom: '1rem' }}>✨ Drop a Thought</h3>
            <form onSubmit={handleSubmit} className="flex-column">
                <input
                    style={{
                        background: 'rgba(0,0,0,0.3)',
                        border: '1px solid var(--border-subtle)',
                        padding: '12px',
                        color: 'white',
                        borderRadius: 'var(--radius-sm)'
                    }}
                    placeholder="What's on your mind? (Title)"
                    value={form.title}
                    onChange={e => setForm({ ...form, title: e.target.value })}
                />

                <textarea
                    style={{
                        background: 'rgba(0,0,0,0.3)',
                        border: '1px solid var(--border-subtle)',
                        padding: '12px',
                        color: 'white',
                        borderRadius: 'var(--radius-sm)',
                        minHeight: '80px',
                        fontFamily: 'inherit'
                    }}
                    placeholder="Details..."
                    value={form.content}
                    onChange={e => setForm({ ...form, content: e.target.value })}
                />

                <div style={{ display: 'flex', gap: '10px' }}>
                    <select
                        style={{
                            background: '#222',
                            color: 'white',
                            border: '1px solid #444',
                            padding: '8px',
                            borderRadius: 'var(--radius-sm)',
                            flex: 1
                        }}
                        value={form.status}
                        onChange={e => setForm({ ...form, status: e.target.value })}
                    >
                        <option value="learning">Learning</option>
                        <option value="doing">Doing</option>
                        <option value="done">Done</option>
                    </select>

                    <input
                        style={{
                            background: 'rgba(0,0,0,0.3)',
                            border: '1px solid var(--border-subtle)',
                            padding: '8px',
                            color: 'white',
                            borderRadius: 'var(--radius-sm)',
                            flex: 2
                        }}
                        placeholder="Tags (comma separated)"
                        value={form.tags}
                        onChange={e => setForm({ ...form, tags: e.target.value })}
                    />
                </div>

                {error && <p style={{ color: 'var(--accent-danger)', fontSize: '0.9rem' }}>{error}</p>}

                <button
                    type="submit"
                    disabled={loading}
                    style={{
                        background: 'linear-gradient(90deg, var(--accent-primary), var(--accent-secondary))',
                        color: 'white',
                        padding: '12px',
                        fontWeight: 'bold',
                        borderRadius: 'var(--radius-sm)',
                        marginTop: '10px'
                    }}
                >
                    {loading ? 'Saving...' : 'Create Note'}
                </button>
            </form>
        </div>
    );
}
