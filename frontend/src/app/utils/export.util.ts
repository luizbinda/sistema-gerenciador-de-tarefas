export class ExportUtil {

    public static download(downloadUrl, filename) {
        const a: any = document.createElement('a');
        a.style = 'display: none';
        a.href = downloadUrl;
        a.download = filename;
        document.body.appendChild(a);
        a.click();
    }

    public static downloadFromBase64(imgBase64: any, fileName?: string): void {
        const defaultFileName = fileName ? fileName : 'download';

        const element = document.createElement('a');
        element.setAttribute('href', `data:image/png;base64,${imgBase64}`);
        element.setAttribute('download', defaultFileName);
        element.style.display = 'none';
        document.body.appendChild(element);
        element.click();
        document.body.removeChild(element);
    }

    public static print(downloadUrl) {
        const frame: any = document.createElement('iframe');
        frame.style = 'display: none';
        frame.src = downloadUrl;
        document.body.appendChild(frame);
        frame.onload = function () {
            frame.contentWindow.focus();
            frame.contentWindow.print();
        };
    }

    public static view(base64) {
        const pdfWindow = window.open('');
        pdfWindow.document.write('<iframe width=\'100%\' height=\'100%\' src=\'' + encodeURI(base64) + '\'></iframe>');
    }
}
