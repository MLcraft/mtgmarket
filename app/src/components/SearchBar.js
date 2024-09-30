import React, { useState } from "react"
import './SearchBar.css'

export const SearchBar = ({ setResults, setSearchQuery, setShowResultText }) => {
    const [query, setQuery] = useState("");

    const handleChange = (event) => {
        setQuery(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        // handle search logic here
        fetch('mock/search/' + query)
          .then(response => response.json())
          .then(data => {
            setResults(data)
            setSearchQuery(query)
            setShowResultText(true)
          })
        console.log(`Searching for ${query}...`);
    }

    return (
        <form onSubmit={handleSubmit}>
          <input class="card-search-bar" type="text" value={query} onChange={handleChange} />
          <button class="card-search-submit-button" type="submit">Search</button>
        </form>
    )
}