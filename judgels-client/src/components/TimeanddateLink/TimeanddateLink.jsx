import { isTLX } from '../../conf';

import './TimeanddateLink.scss';

export function TimeanddateLink({ time, message, children }) {
  const onClick = e => {
    e.preventDefault();

    const date = new Date(time)
      .toISOString()
      .replace(/[-:Z.]/g, '')
      .substring(0, 15);

    window.open(`https://www.timeanddate.com/worldclock/fixedtime.html?msg=${encodeURIComponent(message)}&iso=${date}`);
  };

  if (!isTLX()) {
    return children;
  }
  return (
    <span className="timeanddate" onClick={onClick}>
      {children}
    </span>
  );
}
