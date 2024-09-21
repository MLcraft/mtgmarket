import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

import { SearchBar } from "./components/SearchBar";

const App = () => {

  const [results, setResults] = useState([]);
//  const [loading, setLoading] = useState(false);

//  useEffect(() => {
//    setLoading(true);

//    fetch('search/searchquery')
//      .then(response => response.json())
//      .then(data => {
//        const results = data
//        setLoading(false);
//      })
//  }, []);

//  if (loading) {
//    return <p>Loading...</p>;
//  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <div className="App-intro">
          <h2>Card List</h2>
          <SearchBar setResults={setResults}/>
          {results.map(result =>
            <div>
                {result.source}
                {result.cardName}
                {result.cardImageUrl}
                <img src={result.cardImageUrl} alt={result.cardName} />
            </div>
          )}
        </div>
      </header>
    </div>
  );
}

export default App;