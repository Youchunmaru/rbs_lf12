import * as materialweballJs from 'https://esm.run/@material/web/all.js';
console.debug(materialweballJs);

function initTabs() {
    const tabs = document.getElementById("tabs");
    tabs.addEventListener('change', (event) => {
        // ... perform logic only if index of selected item is 2.
        switch (event.target.activeTabIndex) {
            case 0:
                window.location.assign("/home");
                //window.location.assign("/index.html");
                break;
            case 1:
                window.location.assign("/user/show");
                break;
            case 2:
                window.location.assign("/todo/show");
                break;
            case 3:
                window.location.assign("/calendarEvent/calendar");
                break;
            default:
                break;
        }
    });
}

function initMenu() {
    // This example uses anchor as an ID reference
    const anchorEl = document.body.querySelector('#usage-anchor');
    const menuEl = document.body.querySelector('#usage-menu');

    anchorEl.addEventListener('click', () => { menuEl.open = !menuEl.open; });
}

initMenu();
initTabs();