import styled from 'styled-components';
import { Link, NavLink } from 'react-router-dom';

export const HeaderWrapper = styled.header`
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 80px;
  background-color: #000;
  color: #fff;
  padding: 0 20px;
`;

export const Logo = styled(Link)`
  font-size: 28px;
  font-weight: bold;
  text-decoration: none;
  color: #fff;
`;

export const Nav = styled.nav`
  display: flex;
`;

export const NavItem = styled(NavLink)`
  font-size: 16px;
  text-decoration: none;
  color: #fff;
  margin-left: 20px;

  &.active {
    font-weight: bold;
  }
`;

export const Weather = styled.div`
  display: flex;
  align-items: center;
  font-size: 16px;
  margin-left: auto;

  i {
    margin-right: 10px;
  }
`;
