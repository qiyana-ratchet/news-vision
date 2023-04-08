import React from 'react';
import { Link } from 'react-router-dom';
import { HeaderWrapper, Logo, Nav, NavItem, Weather } from './styles';

const Header = () => {
  return (
    <HeaderWrapper>
      <Logo to="/">NewsVision</Logo>
      <Nav>
        <NavItem end to="/">
          Home
        </NavItem>
        <NavItem to="/news">News</NavItem>
        <NavItem to="/politics">Politics</NavItem>
        <NavItem to="/business">Business</NavItem>
        <NavItem to="/science">Science</NavItem>
        <NavItem to="/health">Health</NavItem>
        <NavItem to="/sports">Sports</NavItem>
      </Nav>
      <Weather>
        <i className="fas fa-sun"></i> 29'C, Sunny
      </Weather>
    </HeaderWrapper>
  );
};

export default Header;
