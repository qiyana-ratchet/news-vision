import styled from 'styled-components';

export const FooterWrapper = styled.footer`
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #4B4B4B;
  color: white;
  padding: 36px;
  font-size: 14px;
  height: 152px;
`;

export const FooterContent = styled.div`
  font-family: 'Prociono', serif;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-bottom: 20px;
  max-width: 1240px;
`;

export const FooterLinks = styled.div`
  font-family: arial, serif, 'Prociono';
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 17px;
  letter-spacing: 0.1px;


  a {
    color: white;
    text-decoration: none;
    margin-right: 30px;
  }

`;

export const Copyright = styled.div`
  font-family: arial, serif, 'Prociono';
  font-size: 13px;
  line-height: 13px;
  text-align: left;
  letter-spacing: 0.2px;
`;
