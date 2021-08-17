<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form action="j_security_check" method="post">
            <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111">
                <tr>
                    <td><b><font size="2">Email</font></b></td>
                    <td><input type="text" name="j_username" size="30"></td>
                </tr>
                <tr>
                    <td><b><font size="2">Senha</font></b></td>
                    <td><input type="password" name="j_password" size="30"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p align="center"><input type="submit" value="Entrar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>