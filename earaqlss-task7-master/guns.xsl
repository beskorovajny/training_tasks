<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Guns</title>
            </head>
            <body>
                <h1>
                    <center>Gun catalog</center>
                </h1>
                <table border="1">
                    <tr>
                        <th>Model</th>
                        <th>Handy</th>
                        <th>Origin</th>
                        <th>Scope type</th>
                        <th>Fire range ,m</th>
                        <th>Fire mode</th>
                        <th>Material</th>
                    </tr>
                    <xsl:for-each select="guns/gun">
                        <tr>
                            <td>
                                <xsl:value-of select="model"/>
                            </td>
                            <td>
                                <xsl:value-of select="handy"/>
                            </td>
                            <td>
                                <xsl:value-of select="origin"/>
                            </td>
                            <td><xsl:value-of select="tacticalCharacteristics/scope/@type"/></td>
                            <td><xsl:value-of select="tacticalCharacteristics/effectiveRange/@range"/></td>
                            <td><xsl:value-of select="tacticalCharacteristics/fireMode/@fireMode"/></td>
                            <td>
                                <xsl:value-of select="material/@material"/>
                            </td>

                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>