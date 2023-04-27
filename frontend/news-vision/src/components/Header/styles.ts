import styled from 'styled-components';
import { Link, NavLink } from 'react-router-dom';

export const HeaderWrapper = styled.header`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 80px;
  background-color: #000;
  color: #fff;
  font-family: 'Prociono', serif;
  font-weight: 400;
`;

export const HeaderContainer = styled.nav`
  display: flex;
  width: 1248px;
  align-items: center;
  height: 80px;
`;

export const Logo = styled(Link)`
  font-size: 40px;
  text-decoration: none;
  color: #fff;
`;

export const Nav = styled.nav`
  display: flex;
  margin-left: 80px;

`;

export const NavItem = styled(NavLink)`
  font-size: 16px;
  text-decoration: none;
  color: #fff;
  margin-left: 40px;

  &.active {
    font-weight: bold;
  }
`;

export const Weather = styled.div`
  display: flex;
  align-items: center;
  font-size: 16px;
  margin-left: 180px;
  font-family: 'Montserrat', sans-serif;
`;
