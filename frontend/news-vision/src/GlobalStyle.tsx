import {createGlobalStyle} from 'styled-components';

const GlobalStyle = createGlobalStyle`
  @font-face {
    font-family: 'ReithSans';
    src: url('assets/fonts/ReithSans_Rg.ttf') format('truetype');
  }

  @font-face {
    font-family: 'ReithSansLt';
    src: url(assets/fonts/BBCReithSans_W_Lt.eot) format('embedded-opentype'),
    url(assets/fonts/BBCReithSans_W_Lt.woff) format('woff'),
    url(assets/fonts/BBCReithSans_W_Lt.woff2) format('woff2');
  }

  @font-face {
    font-family: 'ReithSans1';
    src: url('assets/fonts/MontserratSubrayada-Regular.ttf') format('truetype');
  }

  @font-face {
    font-family: 'Pretendard';
    src: url('assets/fonts/PretendardVariable.ttf') format('truetype');
  }
`;

export default GlobalStyle;