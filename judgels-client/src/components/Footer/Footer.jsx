import HTMLReactParser from 'html-react-parser';

import { APP_CONFIG } from '../../conf';

import './Footer.scss';

export function Footer() {
  const footer = APP_CONFIG.footer || '© Vladimir Voskovshuk';

  return (
    <div className="footer">
      <hr />
      <small className="footer__text">
        <div className="float-left">{HTMLReactParser(footer)}</div>
        <div className="float-right">
          Powered by olimpier
        </div>
        <div className="clearfix" />
      </small>
    </div>
  );
}
