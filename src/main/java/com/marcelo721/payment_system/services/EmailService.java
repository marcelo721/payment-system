package com.marcelo721.payment_system.services;


import com.marcelo721.payment_system.entities.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;


    String verifyUrl = "http://localhost:8080/user/verify?code=";

    public void sendVerifyEmail(User user) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "marceloh.sousa@galu.ufc.br";
        String senderName = "Marcelo721";
        String subject = "please verify your registration";
        String content  = "<!DOCTYPE HTML PUBLIC \\\"-//W3C//DTD XHTML 1.0 Transitional //EN\\\" \\\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\\\">\\n\" +\n" +
                "                \"<html xmlns=\\\"http://www.w3.org/1999/xhtml\\\" xmlns:v=\\\"urn:schemas-microsoft-com:vml\\\" xmlns:o=\\\"urn:schemas-microsoft-com:office:office\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<head>\\n\" +\n" +
                "                \"  <!--[if gte mso 9]>\\n\" +\n" +
                "                \"<xml>\\n\" +\n" +
                "                \"  <o:OfficeDocumentSettings>\\n\" +\n" +
                "                \"    <o:AllowPNG/>\\n\" +\n" +
                "                \"    <o:PixelsPerInch>96</o:PixelsPerInch>\\n\" +\n" +
                "                \"  </o:OfficeDocumentSettings>\\n\" +\n" +
                "                \"</xml>\\n\" +\n" +
                "                \"<![endif]-->\\n\" +\n" +
                "                \"  <meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\\n\" +\n" +
                "                \"  <meta name=\\\"viewport\\\" content=\\\"width=device-width, initial-scale=1.0\\\">\\n\" +\n" +
                "                \"  <meta name=\\\"x-apple-disable-message-reformatting\\\">\\n\" +\n" +
                "                \"  <!--[if !mso]><!-->\\n\" +\n" +
                "                \"  <meta http-equiv=\\\"X-UA-Compatible\\\" content=\\\"IE=edge\\\">\\n\" +\n" +
                "                \"  <!--<![endif]-->\\n\" +\n" +
                "                \"  <title></title>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"  <style type=\\\"text/css\\\">\\n\" +\n" +
                "                \"    @media only screen and (min-width: 620px) {\\n\" +\n" +
                "                \"      .u-row {\\n\" +\n" +
                "                \"        width: 600px !important;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"      .u-row .u-col {\\n\" +\n" +
                "                \"        vertical-align: top;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"      .u-row .u-col-100 {\\n\" +\n" +
                "                \"        width: 600px !important;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    @media (max-width: 620px) {\\n\" +\n" +
                "                \"      .u-row-container {\\n\" +\n" +
                "                \"        max-width: 100% !important;\\n\" +\n" +
                "                \"        padding-left: 0px !important;\\n\" +\n" +
                "                \"        padding-right: 0px !important;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"      .u-row .u-col {\\n\" +\n" +
                "                \"        min-width: 320px !important;\\n\" +\n" +
                "                \"        max-width: 100% !important;\\n\" +\n" +
                "                \"        display: block !important;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"      .u-row {\\n\" +\n" +
                "                \"        width: 100% !important;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"      .u-col {\\n\" +\n" +
                "                \"        width: 100% !important;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"      .u-col>div {\\n\" +\n" +
                "                \"        margin: 0 auto;\\n\" +\n" +
                "                \"      }\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    body {\\n\" +\n" +
                "                \"      margin: 0;\\n\" +\n" +
                "                \"      padding: 0;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    table,\\n\" +\n" +
                "                \"    tr,\\n\" +\n" +
                "                \"    td {\\n\" +\n" +
                "                \"      vertical-align: top;\\n\" +\n" +
                "                \"      border-collapse: collapse;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    p {\\n\" +\n" +
                "                \"      margin: 0;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    .ie-container table,\\n\" +\n" +
                "                \"    .mso-container table {\\n\" +\n" +
                "                \"      table-layout: fixed;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    * {\\n\" +\n" +
                "                \"      line-height: inherit;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    a[x-apple-data-detectors='true'] {\\n\" +\n" +
                "                \"      color: inherit !important;\\n\" +\n" +
                "                \"      text-decoration: none !important;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    table,\\n\" +\n" +
                "                \"    td {\\n\" +\n" +
                "                \"      color: #000000;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"    #u_body a {\\n\" +\n" +
                "                \"      color: #0000ee;\\n\" +\n" +
                "                \"      text-decoration: underline;\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"  </style>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"  <!--[if !mso]><!-->\\n\" +\n" +
                "                \"  <link href=\\\"https://fonts.googleapis.com/css?family=Cabin:400,700\\\" rel=\\\"stylesheet\\\" type=\\\"text/css\\\">\\n\" +\n" +
                "                \"  <!--<![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"</head>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<body class=\\\"clean-body u_body\\\" style=\\\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9;color: #000000\\\">\\n\" +\n" +
                "                \"  <!--[if IE]><div class=\\\"ie-container\\\"><![endif]-->\\n\" +\n" +
                "                \"  <!--[if mso]><div class=\\\"mso-container\\\"><![endif]-->\\n\" +\n" +
                "                \"  <table id=\\\"u_body\\\" style=\\\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\">\\n\" +\n" +
                "                \"    <tbody>\\n\" +\n" +
                "                \"      <tr style=\\\"vertical-align: top\\\">\\n\" +\n" +
                "                \"        <td style=\\\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\\\">\\n\" +\n" +
                "                \"          <!--[if (mso)|(IE)]><table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\"><tr><td align=\\\"center\\\" style=\\\"background-color: #f9f9f9;\\\"><![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"          <div class=\\\"u-row-container\\\" style=\\\"padding: 0px;background-color: transparent\\\">\\n\" +\n" +
                "                \"            <div class=\\\"u-row\\\" style=\\\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\\\">\\n\" +\n" +
                "                \"              <div style=\\\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\\\">\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\"><tr><td style=\\\"padding: 0px;background-color: transparent;\\\" align=\\\"center\\\"><table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\" style=\\\"width:600px;\\\"><tr style=\\\"background-color: transparent;\\\"><![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><td align=\\\"center\\\" width=\\\"600\\\" style=\\\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\" valign=\\\"top\\\"><![endif]-->\\n\" +\n" +
                "                \"                <div class=\\\"u-col u-col-100\\\" style=\\\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\\\">\\n\" +\n" +
                "                \"                  <div style=\\\"height: 100%;width: 100% !important;\\\">\\n\" +\n" +
                "                \"                    <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    <div style=\\\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\">\\n\" +\n" +
                "                \"                      <!--<![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    </div>\\n\" +\n" +
                "                \"                    <!--<![endif]-->\\n\" +\n" +
                "                \"                  </div>\\n\" +\n" +
                "                \"                </div>\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></td><![endif]-->\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\\n\" +\n" +
                "                \"              </div>\\n\" +\n" +
                "                \"            </div>\\n\" +\n" +
                "                \"          </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"          <div class=\\\"u-row-container\\\" style=\\\"padding: 0px;background-color: transparent\\\">\\n\" +\n" +
                "                \"            <div class=\\\"u-row\\\" style=\\\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\\\">\\n\" +\n" +
                "                \"              <div style=\\\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\\\">\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\"><tr><td style=\\\"padding: 0px;background-color: transparent;\\\" align=\\\"center\\\"><table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\" style=\\\"width:600px;\\\"><tr style=\\\"background-color: #ffffff;\\\"><![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><td align=\\\"center\\\" width=\\\"600\\\" style=\\\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\" valign=\\\"top\\\"><![endif]-->\\n\" +\n" +
                "                \"                <div class=\\\"u-col u-col-100\\\" style=\\\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\\\">\\n\" +\n" +
                "                \"                  <div style=\\\"height: 100%;width: 100% !important;\\\">\\n\" +\n" +
                "                \"                    <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    <div style=\\\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\">\\n\" +\n" +
                "                \"                      <!--<![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    </div>\\n\" +\n" +
                "                \"                    <!--<![endif]-->\\n\" +\n" +
                "                \"                  </div>\\n\" +\n" +
                "                \"                </div>\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></td><![endif]-->\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\\n\" +\n" +
                "                \"              </div>\\n\" +\n" +
                "                \"            </div>\\n\" +\n" +
                "                \"          </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"          <div class=\\\"u-row-container\\\" style=\\\"padding: 0px;background-color: transparent\\\">\\n\" +\n" +
                "                \"            <div class=\\\"u-row\\\" style=\\\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #003399;\\\">\\n\" +\n" +
                "                \"              <div style=\\\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\\\">\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\"><tr><td style=\\\"padding: 0px;background-color: transparent;\\\" align=\\\"center\\\"><table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\" style=\\\"width:600px;\\\"><tr style=\\\"background-color: #003399;\\\"><![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><td align=\\\"center\\\" width=\\\"600\\\" style=\\\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\" valign=\\\"top\\\"><![endif]-->\\n\" +\n" +
                "                \"                <div class=\\\"u-col u-col-100\\\" style=\\\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\\\">\\n\" +\n" +
                "                \"                  <div style=\\\"height: 100%;width: 100% !important;\\\">\\n\" +\n" +
                "                \"                    <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    <div style=\\\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\">\\n\" +\n" +
                "                \"                      <!--<![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <table style=\\\"font-family:'Cabin',sans-serif;\\\" role=\\\"presentation\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" width=\\\"100%\\\" border=\\\"0\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                          <tr>\\n\" +\n" +
                "                \"                            <td style=\\\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Cabin',sans-serif;\\\" align=\\\"left\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                              <table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\">\\n\" +\n" +
                "                \"                                <tr>\\n\" +\n" +
                "                \"                                  <td style=\\\"padding-right: 0px;padding-left: 0px;\\\" align=\\\"center\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                                    <img align=\\\"center\\\" border=\\\"0\\\" src=\\\"https://cdn.templates.unlayer.com/assets/1597218650916-xxxxc.png\\\" alt=\\\"Image\\\" title=\\\"Image\\\" style=\\\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 26%;max-width: 150.8px;\\\"\\n\" +\n" +
                "                \"                                      width=\\\"150.8\\\" />\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                                  </td>\\n\" +\n" +
                "                \"                                </tr>\\n\" +\n" +
                "                \"                              </table>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                            </td>\\n\" +\n" +
                "                \"                          </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                      </table>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <table style=\\\"font-family:'Cabin',sans-serif;\\\" role=\\\"presentation\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" width=\\\"100%\\\" border=\\\"0\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                          <tr>\\n\" +\n" +
                "                \"                            <td style=\\\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\\\" align=\\\"left\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                              <div style=\\\"font-size: 14px; color: #e5eaf5; line-height: 140%; text-align: center; word-wrap: break-word;\\\">\\n\" +\n" +
                "                \"                                <p style=\\\"font-size: 14px; line-height: 140%;\\\"><strong>Muito obrigado por se registrar</strong></p>\\n\" +\n" +
                "                \"                              </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                            </td>\\n\" +\n" +
                "                \"                          </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                      </table>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <table style=\\\"font-family:'Cabin',sans-serif;\\\" role=\\\"presentation\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" width=\\\"100%\\\" border=\\\"0\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                          <tr>\\n\" +\n" +
                "                \"                            <td style=\\\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 31px;font-family:'Cabin',sans-serif;\\\" align=\\\"left\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                              <div style=\\\"font-size: 14px; color: #e5eaf5; line-height: 140%; text-align: center; word-wrap: break-word;\\\">\\n\" +\n" +
                "                \"                                <p style=\\\"font-size: 14px; line-height: 140%;\\\"><span style=\\\"font-size: 28px; line-height: 39.2px;\\\"><strong><span style=\\\"line-height: 39.2px; font-size: 28px;\\\">Verifique o seu e-mail</span></strong>\\n\" +\n" +
                "                \"                                  </span>\\n\" +\n" +
                "                \"                                </p>\\n\" +\n" +
                "                \"                              </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                            </td>\\n\" +\n" +
                "                \"                          </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                      </table>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    </div>\\n\" +\n" +
                "                \"                    <!--<![endif]-->\\n\" +\n" +
                "                \"                  </div>\\n\" +\n" +
                "                \"                </div>\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></td><![endif]-->\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\\n\" +\n" +
                "                \"              </div>\\n\" +\n" +
                "                \"            </div>\\n\" +\n" +
                "                \"          </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"          <div class=\\\"u-row-container\\\" style=\\\"padding: 0px;background-color: transparent\\\">\\n\" +\n" +
                "                \"            <div class=\\\"u-row\\\" style=\\\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\\\">\\n\" +\n" +
                "                \"              <div style=\\\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\\\">\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\"><tr><td style=\\\"padding: 0px;background-color: transparent;\\\" align=\\\"center\\\"><table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\" style=\\\"width:600px;\\\"><tr style=\\\"background-color: #ffffff;\\\"><![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><td align=\\\"center\\\" width=\\\"600\\\" style=\\\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\" valign=\\\"top\\\"><![endif]-->\\n\" +\n" +
                "                \"                <div class=\\\"u-col u-col-100\\\" style=\\\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\\\">\\n\" +\n" +
                "                \"                  <div style=\\\"height: 100%;width: 100% !important;\\\">\\n\" +\n" +
                "                \"                    <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    <div style=\\\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\">\\n\" +\n" +
                "                \"                      <!--<![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <table style=\\\"font-family:'Cabin',sans-serif;\\\" role=\\\"presentation\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" width=\\\"100%\\\" border=\\\"0\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                          <tr>\\n\" +\n" +
                "                \"                            <td style=\\\"overflow-wrap:break-word;word-break:break-word;padding:33px 55px;font-family:'Cabin',sans-serif;\\\" align=\\\"left\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                              <div style=\\\"font-size: 14px; line-height: 160%; text-align: center; word-wrap: break-word;\\\">\\n\" +\n" +
                "                \"                                <p style=\\\"font-size: 14px; line-height: 160%;\\\"><span style=\\\"font-size: 22px; line-height: 35.2px;\\\">Olá [[NAME]], </span></p>\\n\" +\n" +
                "                \"                                <p style=\\\"font-size: 14px; line-height: 160%;\\\"><span style=\\\"font-size: 18px; line-height: 28.8px;\\\">Você inicou a criação da sua conta mas falta um ultimo passo! Clique no botão abaixo e confirme o seu registro</span></p>\\n\" +\n" +
                "                \"                              </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                            </td>\\n\" +\n" +
                "                \"                          </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                      </table>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <table style=\\\"font-family:'Cabin',sans-serif;\\\" role=\\\"presentation\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" width=\\\"100%\\\" border=\\\"0\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                          <tr>\\n\" +\n" +
                "                \"                            <td style=\\\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\\\" align=\\\"left\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                              <!--[if mso]><style>.v-button {background: transparent !important;}</style><![endif]-->\\n\" +\n" +
                "                \"                              <div align=\\\"center\\\">\\n\" +\n" +
                "                \"                                <!--[if mso]><v:roundrect xmlns:v=\\\"urn:schemas-microsoft-com:vml\\\" xmlns:w=\\\"urn:schemas-microsoft-com:office:word\\\" href=\\\"[[URL]]\\\" style=\\\"height:46px; v-text-anchor:middle; width:219px;\\\" arcsize=\\\"8.5%\\\"  stroke=\\\"f\\\" fillcolor=\\\"#ff6600\\\"><w:anchorlock/><center style=\\\"color:#FFFFFF;\\\"><![endif]-->\\n\" +\n" +
                "                \"                                <a href=\\\"[[URL]]\\\" target=\\\"_blank\\\" class=\\\"v-button\\\" style=\\\"box-sizing: border-box;display: inline-block;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #ff6600; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;font-size: 14px;\\\">\\n\" +\n" +
                "                \"                                  <span style=\\\"display:block;padding:14px 44px 13px;line-height:120%;\\\"><span style=\\\"font-size: 16px; line-height: 19.2px;\\\"><strong><span style=\\\"line-height: 19.2px; font-size: 16px;\\\">Verifique seu email</span></strong>\\n\" +\n" +
                "                \"                                  </span>\\n\" +\n" +
                "                \"                                  </span>\\n\" +\n" +
                "                \"                                </a>\\n\" +\n" +
                "                \"                                <!--[if mso]></center></v:roundrect><![endif]-->\\n\" +\n" +
                "                \"                              </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                            </td>\\n\" +\n" +
                "                \"                          </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                      </table>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <table style=\\\"font-family:'Cabin',sans-serif;\\\" role=\\\"presentation\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" width=\\\"100%\\\" border=\\\"0\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                          <tr>\\n\" +\n" +
                "                \"                            <td style=\\\"overflow-wrap:break-word;word-break:break-word;padding:33px 55px 60px;font-family:'Cabin',sans-serif;\\\" align=\\\"left\\\">\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                              <div style=\\\"font-size: 14px; line-height: 160%; text-align: center; word-wrap: break-word;\\\">\\n\" +\n" +
                "                \"                                <p style=\\\"line-height: 160%; font-size: 14px;\\\"><span style=\\\"font-size: 18px; line-height: 28.8px;\\\">Obrigado!</span></p>\\n\" +\n" +
                "                \"                              </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                            </td>\\n\" +\n" +
                "                \"                          </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                      </table>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    </div>\\n\" +\n" +
                "                \"                    <!--<![endif]-->\\n\" +\n" +
                "                \"                  </div>\\n\" +\n" +
                "                \"                </div>\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></td><![endif]-->\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\\n\" +\n" +
                "                \"              </div>\\n\" +\n" +
                "                \"            </div>\\n\" +\n" +
                "                \"          </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"          <div class=\\\"u-row-container\\\" style=\\\"padding: 0px;background-color: transparent\\\">\\n\" +\n" +
                "                \"            <div class=\\\"u-row\\\" style=\\\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #e5eaf5;\\\">\\n\" +\n" +
                "                \"              <div style=\\\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\\\">\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\"><tr><td style=\\\"padding: 0px;background-color: transparent;\\\" align=\\\"center\\\"><table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\" style=\\\"width:600px;\\\"><tr style=\\\"background-color: #e5eaf5;\\\"><![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><td align=\\\"center\\\" width=\\\"600\\\" style=\\\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\" valign=\\\"top\\\"><![endif]-->\\n\" +\n" +
                "                \"                <div class=\\\"u-col u-col-100\\\" style=\\\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\\\">\\n\" +\n" +
                "                \"                  <div style=\\\"height: 100%;width: 100% !important;\\\">\\n\" +\n" +
                "                \"                    <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    <div style=\\\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\">\\n\" +\n" +
                "                \"                      <!--<![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    </div>\\n\" +\n" +
                "                \"                    <!--<![endif]-->\\n\" +\n" +
                "                \"                  </div>\\n\" +\n" +
                "                \"                </div>\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></td><![endif]-->\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\\n\" +\n" +
                "                \"              </div>\\n\" +\n" +
                "                \"            </div>\\n\" +\n" +
                "                \"          </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"          <div class=\\\"u-row-container\\\" style=\\\"padding: 0px;background-color: transparent\\\">\\n\" +\n" +
                "                \"            <div class=\\\"u-row\\\" style=\\\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #003399;\\\">\\n\" +\n" +
                "                \"              <div style=\\\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\\\">\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\"><tr><td style=\\\"padding: 0px;background-color: transparent;\\\" align=\\\"center\\\"><table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" border=\\\"0\\\" style=\\\"width:600px;\\\"><tr style=\\\"background-color: #003399;\\\"><![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]><td align=\\\"center\\\" width=\\\"600\\\" style=\\\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\" valign=\\\"top\\\"><![endif]-->\\n\" +\n" +
                "                \"                <div class=\\\"u-col u-col-100\\\" style=\\\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\\\">\\n\" +\n" +
                "                \"                  <div style=\\\"height: 100%;width: 100% !important;\\\">\\n\" +\n" +
                "                \"                    <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    <div style=\\\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\\\">\\n\" +\n" +
                "                \"                      <!--<![endif]-->\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                      <!--[if (!mso)&(!IE)]><!-->\\n\" +\n" +
                "                \"                    </div>\\n\" +\n" +
                "                \"                    <!--<![endif]-->\\n\" +\n" +
                "                \"                  </div>\\n\" +\n" +
                "                \"                </div>\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></td><![endif]-->\\n\" +\n" +
                "                \"                <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\\n\" +\n" +
                "                \"              </div>\\n\" +\n" +
                "                \"            </div>\\n\" +\n" +
                "                \"          </div>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\\n\" +\n" +
                "                \"        </td>\\n\" +\n" +
                "                \"      </tr>\\n\" +\n" +
                "                \"    </tbody>\\n\" +\n" +
                "                \"  </table>\\n\" +\n" +
                "                \"  <!--[if mso]></div><![endif]-->\\n\" +\n" +
                "                \"  <!--[if IE]></div><![endif]-->\\n\" +\n" +
                "                \"</body>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"</html>";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[NAME]]", user.getName());
        String verifyUrl = this.verifyUrl + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyUrl);
        helper.setText(content, true);

        javaMailSender.send(message);

    }
}
