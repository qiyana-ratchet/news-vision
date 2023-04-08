import styled from 'styled-components';

export const FooterWrapper = styled.footer`
display: flex;
flex-direction: column;
background-color: #f5f5f5;
color: #7a7a7a;
padding: 20px;
font-size: 14px;
`;

export const FooterContent = styled.div`
display: flex;
align-items: center;
justify-content: space-between;
margin-bottom: 20px;
`;

export const FooterLinks = styled.div`
display: flex;
flex-wrap: wrap;

a {
  color: #7a7a7a;
  text-decoration: none;
  margin-right: 20px;
}
`;
