import React from 'react';
import { Link } from 'react-router-dom';
import { HeaderWrapper, HeaderContainer, Logo, Nav, NavItem, Weather } from './styles';
import Sunny from "../../assets/images/sunny.png";

const Header = () => {
  return (
    <HeaderWrapper>
      <HeaderContainer>
      <Logo to="/">News</Logo>
      <Logo to="/" style={{color: '#6CAFFF'}}>V</Logo>
      <Logo to="/">ision</Logo>
      <Nav>
        <NavItem end to="/" style={{color: '#6CAFFF'}}>
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
        <img src={Sunny} alt="sun" style={{width:32, marginRight:10}}/> 29'C, Sunny
      </Weather>
      </HeaderContainer>
    </HeaderWrapper>
  );
};

export default Header;
