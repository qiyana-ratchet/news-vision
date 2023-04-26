import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Home from './pages/Home/Home';
import Article from './pages/Article/Article';
import GlobalStyle from './GlobalStyle';

const App = () => {
  return (
    <>
      <GlobalStyle/>
      <Router>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/article" element={<Article/>}/>
        </Routes>
      </Router>
    </>
  );
};

export default App;
