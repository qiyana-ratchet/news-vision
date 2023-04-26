import React from 'react';
import {FooterWrapper, FooterContent, FooterLinks,Copyright} from './styles';

const Footer = () => {
  return (
    <FooterWrapper>
      <FooterContent>
        <span style={{fontSize: 32}}>NewsVision</span>
        <span style={{fontSize: 15, marginTop: 20}}>2023 Konkuk University, Graduation Project</span>
        <div style={{maxWidth: 1240}}>
          <hr
            style={{
              height: 5,
              border: '0px solid #7D7D7D',
              borderTopWidth: 1,
              marginTop: 17,
              marginBottom: 16,
            }}
          />
        </div>
        <FooterLinks>
          <a href="/">Terms of Use</a>
          <a href="/">About NewsVision</a>
          <a href="/">Privacy Policy</a>
          <a href="/">Cookies</a>
          <a href="/">Accessibility Help</a>
          <a href="/">Parental Guidance</a>
          <a href="/">Contact Us</a>
          <a href="/">Advertise With Us</a>
          <a href="/">AdChoices / Sponsor Us</a>
        </FooterLinks>
        <Copyright>
          <span>Copyright ©</span>
          <span style={{fontWeight: 700}}>2023 NewsVision. </span>
          <span>
      NewsVision is not responsible for the content of external sites. Read
      about our approach to external linking.
    </span>
        </Copyright>

      </FooterContent>
    </FooterWrapper>
  );
};

export default Footer;