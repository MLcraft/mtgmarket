import React, { useState } from "react"

export const SearchBar = ({ setResults }) => {
    const [query, setQuery] = useState("");

    const handleChange = (event) => {
        setQuery(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        // handle search logic here
        fetch('search/' + query)
          .then(response => response.json())
          .then(data => {
            setResults(data)
          })
        console.log(`Searching for ${query}...`);
    }

    return (
        <form onSubmit={handleSubmit}>
          <input type="text" value={query} onChange={handleChange} />
          <button type="submit">Search</button>
        </form>
    )
}