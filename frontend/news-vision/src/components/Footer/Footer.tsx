import React from 'react';
import {FooterWrapper, FooterContent, FooterLinks} from './styles';

const Footer = () => {
  return (
    <FooterWrapper>
      <FooterContent>
        <span>NewsVision</span>
        <span>2023 Konkuk University, Graduation Project</span>
      </FooterContent>
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
      <div>
        <span>Copyright © 2023 NewsVision. </span>
        <span>
      NewsVision is not responsible for the content of external sites. Read
      about our approach to external linking.
    </span>
      </div>
    </FooterWrapper>
  );
};

export default Footer;