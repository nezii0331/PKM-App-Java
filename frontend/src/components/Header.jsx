// this is to practice how to separate the header from the App.jsx

import React from "react";

export default function Header() {
    return (
        <header className="title-section">
            <div>
                <h1>
                    <span>My Knowledge Base</span>
                </h1>
                <p>
                    Manage Your Learning Journey
                </p>
            </div>
        </header>
    );
}