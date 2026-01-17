import React from 'react';

export default function NoteCard({ note }) {
    // Determine border color based on status
    const getStatusColor = (s) => {
        switch (s) {
            case 'Idea': return 'var(--accent-primary)'; // Blue
            case 'Active': return 'var(--accent-secondary)'; // Purple
            default: return '#999';
        }
    };

    return (
        <div
            className="glass-panel"
            style={{
                padding: '1.5rem',
                borderRadius: 'var(--radius-md)',
                marginBottom: '1rem',
                transition: 'transform 0.2s, box-shadow 0.2s',
                cursor: 'default',
                position: 'relative',
                overflow: 'hidden'
            }}
            onMouseEnter={(e) => {
                e.currentTarget.style.transform = 'translateY(-4px)';
                e.currentTarget.style.boxShadow = 'var(--shadow-glow)';
            }}
            onMouseLeave={(e) => {
                e.currentTarget.style.transform = 'none';
                e.currentTarget.style.boxShadow = 'none';
            }}
        >
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '0.5rem' }}>
                <h3 style={{ fontSize: '1.1rem' }}>{note.title || "Untitled Note"}</h3>
                <span style={{
                    fontSize: '0.7rem',
                    padding: '2px 8px',
                    borderRadius: '10px',
                    border: `1px solid ${getStatusColor(note.status)}`,
                    color: getStatusColor(note.status),
                    textTransform: 'uppercase'
                }}>
                    {note.status || 'Draft'}
                </span>
            </div>

            <p style={{
                color: 'var(--text-muted)',
                fontSize: '0.9rem',
                lineHeight: '1.5',
                marginBottom: '1rem',
                whiteSpace: 'pre-wrap'
            }}>
                {note.content}
            </p>

            {/* Footer: Tags & Date */}
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginTop: 'auto' }}>
                <div style={{ display: 'flex', gap: '8px', flexWrap: 'wrap' }}>
                    {note.tags && note.tags.map((tag, i) => (
                        <span key={i} style={{ fontSize: '0.75rem', color: '#888' }}>#{tag}</span>
                    ))}
                </div>
                <div style={{ fontSize: '0.7rem', color: '#555' }}>
                    {note.createdAt && note.createdAt.slice(0, 10)}
                </div>
            </div>
        </div>
    );
}
