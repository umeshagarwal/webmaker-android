var fs = require('fs');

// Prep all entry points
var entry = {};
fs.readdirSync('./www_src/pages').forEach(function (page) {
  entry[page] = './www_src/pages/' + page + '/' + page + '.jsx';
});

module.exports = {
  entry: entry,
  devtool: 'source-map', //not good for ff
  output: {
    path: __dirname + '/app/src/main/assets/www/js',
    filename: '[name].bundle.js'
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        loaders:  ['babel-loader']
      },
      {
        test: /\.jsx$/,
        loaders:  ['babel-loader', 'jsx-loader']
      },
      {
        test: /\.json$/,
        loader: 'json-loader'
      }
    ]
  }
};