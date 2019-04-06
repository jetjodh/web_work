<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Review Collection</h2>
  <table border="1">
    <tr bgcolor="#4CAF50">
        <th style="text-align:left">Title</th>
        <th style="text-align:left">Director</th>
        <th style="text-align:left">Genre</th>
        <th style="text-align:left">Year of Release</th>
    </tr>
    <xsl:for-each select="review_list/Movies/movie">
    <tr>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="director"/></td>
        <td><xsl:value-of select="genre"/></td>
        <td><xsl:value-of select="releaseYear"/></td>
    </tr>
    </xsl:for-each>
  </table>
    <table border="1">
    <tr bgcolor="#4CAF50">
        <th style="text-align:left">title</th>
        <th style="text-align:left">Genre</th>
        <th style="text-align:left">Year of Release</th>
    </tr>
    <xsl:for-each select="review_list/Games/Game">
    <tr>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="genre"/></td>
        <td><xsl:value-of select="releaseYear"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>