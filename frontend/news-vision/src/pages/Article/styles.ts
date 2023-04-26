import styled from 'styled-components';

export const SiteWrapper = styled.div`
  display: flex;
  align-items: center;
`;

export const SiteContainer = styled.div`
  display: flex;
  flex-direction: row;
  margin: 0 auto;
`;

export const ArticleWrapper = styled.main`
  max-width: 850px;
  padding: 20px;
`;

export const ArticleHeader = styled.div`
  margin-bottom: 40px;
`;

export const ArticleTitle = styled.h1`
  font-family: 'Noto Sans KR', Arial;
  font-style: normal;
  font-weight: 400;
  font-size: 44px;
  line-height: 100%;
  /* or 44px */
  letter-spacing: -0.28px;
  color: #000000;
  margin-bottom: 15px;
  margin-top: -15px;
  line-height: 115%;
`;

export const ArticleDate = styled.span`
  font-family: 'Montserrat';
  font-weight: 400;
  font-size: 15px;
  line-height: 100%;
  /* identical to box height, or 15px */
  letter-spacing: -0.28px;
  color: #000000;
`;

export const ArticleImgWrapper = styled.div`
  height: 400px;
  background-color: #ddd;
  margin-bottom: 20px;
  margin-top: 14px;
`;

export const ArticleImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

export const ArticleContent = styled.div`
  height: 600px;

  p {
    margin-bottom: 20px;
    line-height: 1.5;
    font-size: 1.2rem;
  }
`;

export const NavBarWrapper = styled.div`
  position: relative;
  width: 300px;
  display: flex;
  flex-direction: column;
  margin-top: 56px;
  margin-left: 100px;
`;

export const NavBarTitle = styled.div`
  font-size: 1.5rem;
  font-weight: 600;
`;

export const NavBarPost = styled.div`
  margin-top: 20px;
  width: ${330 - 32}px;
  display: flex;
  flex-direction: column;
  background-color: #F6F6F6;
  padding: 16px;
`;

export const NavBarPostTitle = styled.div`
  font-size: 18px;
  font-weight: 400;
  font-family: ReithSerif, Helvetica, Arial;
  letter-spacing: 0.02em;
`;

export const NavBarPostDesc = styled.div`
  font-size: 12px;
  font-weight: normal;
  font-family: ReithSerif, Helvetica, Arial;
  margin-top: 10px;
  color: #545658;
  letter-spacing: 0.06em;

`;

export const NavBarFeatures = styled.div`
  width: 300px;
  display: flex;
  flex-direction: column;
  margin-top: 20px;
`;

export const NavImgWrapper = styled.div`
  width: 330px;
  height: 180px;
  margin-top: 85px;
`;

export const NavBarImg = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

export const DescWrapper = styled.div`
  height: 70px;
  background-color: #F6F6F6;
  display: flex;
  align-items: center;
  padding: 0px 20px;
`;

export const NavBarImgDesc = styled.div`
  font-size: 20px;
  font-weight: 400;
  font-family: ReithSerif, Helvetica, Arial;
  letter-spacing: 0.02em;
`;


