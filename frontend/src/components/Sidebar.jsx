import React from 'react';

export default function Sidebar() {
    return (
        <aside className="sidebar-area glass-nav">
            <div className="logo-section" style={{ marginBottom: '2rem' }}>
                <h2 style={{ fontSize: '1.5rem', display: 'flex', alignItems: 'center', gap: '10px' }}>
                    <span>PKM App</span>
                </h2>
                <p style={{ marginTop: '0.5rem', fontSize: '0.8rem', color: 'var(--text-muted)' }}>
                    Second Brain v1.0
                </p>
            </div>

            <nav className="flex-column">
                {['All Notes', 'Learning', 'Doing', 'Done'].map((item, idx) => (
                    <div
                        key={item}
                        style={{
                            padding: '10px 14px',
                            borderRadius: 'var(--radius-sm)',
                            cursor: 'pointer',
                            backgroundColor: idx === 0 ? 'rgba(76, 201, 240, 0.1)' : 'transparent',
                            color: idx === 0 ? 'var(--accent-primary)' : 'var(--text-muted)',
                            borderLeft: idx === 0 ? '3px solid var(--accent-primary)' : '3px solid transparent'
                        }}
                    >
                        {item}
                    </div>
                ))}
            </nav>

            <div style={{ marginTop: 'auto', padding: '1rem', borderTop: '1px solid var(--border-subtle)' }}>
                <small style={{ color: 'var(--text-muted)' }}>Connected to Spring Boot</small>
            </div>
        </aside>
    );
}
